package mls.front_client.controllers;

import mls.front_client.dto.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Controller
public class PropertyController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    private String getServerUri() {
        ServiceInstance instance = loadBalancerClient.choose("localhost: 8090");
        return instance.getUri().toString() + "/api/property";
    }

        @GetMapping("/api/property")
        @ResponseBody
        public ResponseEntity getAllProducts(){
            String url = getServerUri();
            RestTemplate restTemplate = new RestTemplate();

            RequestEntity<Void> request = RequestEntity.get(url)
                    .accept(MediaType.APPLICATION_JSON).build();

            ParameterizedTypeReference<Optional<List<Property>>> responseType =
                    new ParameterizedTypeReference<Optional<List<Property>>>() {};

            Optional<List<Property>> properties =  restTemplate.exchange(request, responseType).getBody();


            return ResponseEntity.ok(properties.get());
        }

        @GetMapping("/product/{product_id}")
        public String getProduct(@PathVariable long product_id, Model model) {
            String url = getProductBaseUri()  + product_id;
            RestTemplate restTemplate = new RestTemplate();

            RequestEntity<Void> request = RequestEntity.get(url)
                    .accept(MediaType.APPLICATION_JSON).build();

            ParameterizedTypeReference<Optional<Product>> responseType =
                    new ParameterizedTypeReference<Optional<Product>>() {};

            Optional<Product> product =  restTemplate.exchange(request, responseType).getBody();

            if(product.isEmpty()) {
                model.addAttribute("error","No Review for this product");
            }
            else {
                model.addAttribute("productName",product.get().getProductName());
                model.addAttribute("price",product.get().get_price());
            }

            model.addAttribute("productId",product_id);

            return "product/product";
        }

        @PutMapping("product/update")
        public String updateProduct(@RequestBody Product product) {
            String url = getProductBaseUri() + "update-product";
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<String>(product.mapJson().toString(), headers);
            restTemplate.put(url,entity);
            return "index";
        }

        @PostMapping("product/post")
        public String postProduct(@RequestBody Product product) {
            String url = getProductBaseUri() + "post-product";
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<String>(product.mapJson().toString(), headers);

            restTemplate.postForEntity(url,entity, Product.class);
            return "index";
        }

        @SuppressWarnings("unchecked")
        @DeleteMapping("product/delete/{product_id}")
        public String DeleteProduct(@PathVariable long product_id, Model model) {
            String url = getProductBaseUri() + product_id;
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.delete(url);

            return "index";
        }


        @PostMapping("/review/{product_id}")
        public String postReview(@PathVariable long product_id, @RequestBody ProductReview review) {
            String url = getReviewBaseUri() + "post-review/" + product_id;
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<String>(review.mapJson().toString(), headers);

            ProductReview reviewResult = restTemplate.postForObject(url,entity, ProductReview.class);

//		String returnUrl = "/reviews/" + review.get_productId();

//		RedirectView redirectView = new RedirectView();
//	    redirectView.setUrl(returnUrl);
            return "product/review";
        }

        @PutMapping("/update-review/{review_id}")
        public String updateReview(@RequestBody ProductReview review, @PathVariable long review_id) {
            String url = getReviewBaseUri() + review_id;

            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<String>(review.mapJson().toString(), headers);
            restTemplate.put(url,entity);

//		String returnUrl = "/reviews/" + review.get_productId();
//		model.setViewName(returnUrl);
            return "product/review";

        }


        @GetMapping("/review/{product_id}")
        public String addReview(@PathVariable long product_id, Model model) {
            model.addAttribute("productId",product_id);
            model.addAttribute("review", new ProductReview());
            return "product/review";
        }

        @SuppressWarnings("unchecked")
        @GetMapping("/reviews/{product_id}")
        public String getReviews(@PathVariable long product_id, Model model) {
            String url = getReviewBaseUri() + product_id;
            RestTemplate restTemplate = new RestTemplate();
            Optional<List<ProductReview>> review = restTemplate.getForObject(url, Optional.class);
            if(review.isEmpty()) {
                model.addAttribute("error","No Review for this product");
            }
            else {
                model.addAttribute("reivews",review.get());
            }

            model.addAttribute("productId",product_id);

            return "product/reviewList";
        }

        @SuppressWarnings("unchecked")
        @GetMapping("/review/{user_name}/{product_id}")
        public String getReview(@PathVariable long product_id, @PathVariable String user_name, Model model) {
            String url = getReviewBaseUri() + product_id + "/" + user_name;
            RestTemplate restTemplate = new RestTemplate();
            //Optional<ProductReview> review = restTemplate.getForObject(url, Optional.class);
            RequestEntity<Void> request = RequestEntity.get(url)
                    .accept(MediaType.APPLICATION_JSON).build();
            ParameterizedTypeReference<Optional<ProductReview>> responseType =
                    new ParameterizedTypeReference<Optional<ProductReview>>() {};
            Optional<ProductReview> review =  restTemplate.exchange(request, responseType).getBody();

            if(review == null) {
                model.addAttribute("error","No Review for this product");
                model.addAttribute("productId",product_id);
            }
            else {
                model.addAttribute("reviewId",review.get().get_productReviewId());
                model.addAttribute("rate",review.get().get_rate());
                model.addAttribute("review",review.get().get_review());
                model.addAttribute("quantity",review.get().get_quantity());
                model.addAttribute("username",review.get().get_userName());
                model.addAttribute("productId",product_id);
            }

            return "product/review";
        }

        @SuppressWarnings("unchecked")
        @DeleteMapping("/review/{review_id}")
        public String deleteReview( @PathVariable long review_id) {
            RestTemplate restTemplate = new RestTemplate();
            String url = getReviewBaseUri()+ review_id;
            restTemplate.delete(url);
            return "product/review";
        }
    }



}
