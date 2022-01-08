package frontend.demo.controller;

import frontend.demo.model.SearchInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class searchInfoController {


    @GetMapping
    public String getSearchInfo(SearchInfo searchInfo, Model model) {
        model.addAttribute("info", searchInfo);
        return "index";
    }

    @PostMapping
    public String postSearchInfo(SearchInfo searchInfo, Model model) {
        model.addAttribute("info", searchInfo);
        return "result";
    }

    @ModelAttribute("allTypes")
    public String[] allMessageTypes () {
        return new String[] { "Land", "House", "Condo" };
    }
}
