//package mls.server_property.bookstrap;
//
//import mls.server_property.domain.*;
//import mls.server_property.services.PropertyService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.sql.Date;
//import java.util.Random;
//
//@Component
//public class BootStrapData implements CommandLineRunner {
//
//    private final PropertyService propertyService;
//
//    @Autowired
//    public BootStrapData(PropertyService propertyService) {
//        this.propertyService = propertyService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("Started in Bootstrap");
//        Random r = new Random();
//
//        // under Property
//        Property ld1 = new Land(null,"land"+r.nextInt(1000),1000);
//        Property ld2 = new Land(null,"zab"+r.nextInt(1000),100000);
//        propertyService.addNewProperty(ld1);
//        propertyService.addNewProperty(ld2);
//
//        // under Residential
//        Property ch1 = new CooperativeHome(null,"coooperativehome"+r.nextInt(1000),1000,null,null,null,null);
//        Property ch2 = new CooperativeHome(null,"zab"+r.nextInt(1000),100000,null,null,null,null);
//        propertyService.addNewProperty(ch1);
//        propertyService.addNewProperty(ch2);
//
//        Property mh1 = new MobileHome(null,"mobilehome"+r.nextInt(1000),1000,null,null,null,null,"single");
//        Property mh2 = new MobileHome(null,"zab"+r.nextInt(1000),100000,null,null,null,null,"shared");
//        propertyService.addNewProperty(mh1);
//        propertyService.addNewProperty(mh2);
//
//        // under Freehold
//        Property fh1 = new FarmHouse(null,"framhouse"+r.nextInt(1000),1000,0,"above",null,Date.valueOf("2019-01-01"),null,3,true);
//        Property fh2 = new FarmHouse(null,"zab"+r.nextInt(1000),100000,2,"above",1,null,"recommended",null,false);
//        propertyService.addNewProperty(fh1);
//        propertyService.addNewProperty(fh2);
//
//        Property ml1 = new MultiLex(null,"multilex"+r.nextInt(1000),1000,0,"above",null,Date.valueOf("2019-01-01"),null,3,true);
//        Property ml2 = new MultiLex(null,"zab"+r.nextInt(1000),100000,2,"above",1,null,"recommended",null,false);
//        propertyService.addNewProperty(ml1);
//        propertyService.addNewProperty(ml2);
//
//        Property dh1 = new DetachedHome(null,"detachedhome"+r.nextInt(1000),1000,0,"above",null,Date.valueOf("2019-01-01"),null,3,true);
//        Property dh2 = new DetachedHome(null,"zab"+r.nextInt(1000),100000,2,"above",1,null,"recommended",null,false);
//        propertyService.addNewProperty(dh1);
//        propertyService.addNewProperty(dh2);
//
//        Property vh1 = new VacationHome(null,"vacationhome"+r.nextInt(1000),1000,0,"above",null,Date.valueOf("2019-01-01"),null,3,true);
//        Property vh2 = new VacationHome(null,"zab"+r.nextInt(1000),100000,2,"above",1,null,"recommended",null,false);
//        propertyService.addNewProperty(vh1);
//        propertyService.addNewProperty(vh2);
//
//        Property th1 = new TownHouse(null,"townhouse"+r.nextInt(1000),1000,0,"above",null,Date.valueOf("2019-01-01"),null,3,true);
//        Property th2 = new TownHouse(null,"zab"+r.nextInt(1000),100000,2,"above",1,null,"recommended",null,false);
//        propertyService.addNewProperty(th1);
//        propertyService.addNewProperty(th2);
//
//        Property sd1 = new SemiDetached(null,"semidetached"+r.nextInt(1000),1000,0,"above",null,Date.valueOf("2019-01-01"),null,3,true);
//        Property sd2 = new SemiDetached(null,"zab"+r.nextInt(1000),100000,2,"above",1,null,"recommended",null,false);
//        propertyService.addNewProperty(sd1);
//        propertyService.addNewProperty(sd2);
//
//        // under Condominium
//        Property td1 = new TripleDeckers(null, "tripledeckers" + r.nextInt(1000), 1000, 0, "under", null, Date.valueOf("2009-01-01"), 4);
//        Property td2 = new TripleDeckers(null, "zab" + r.nextInt(1000), 100000, 2, "under", 1, null, 3);
//        propertyService.addNewProperty(td1);
//        propertyService.addNewProperty(td2);
//
//        Property condo1 = new Condo(null, "condo" + r.nextInt(1000), 1000, 0, "under", null, Date.valueOf("2009-01-01"), 4);
//        Property condo2 = new Condo(null, "zab" + r.nextInt(1000), 100000, 2, "under", 1, null, 3);
//        propertyService.addNewProperty(condo1);
//        propertyService.addNewProperty(condo2);
//
//        Property stackedTownHouse1 = new StackedTownHouse(null, "stackedtownhouse" + r.nextInt(1000), 1000, 0, "under", null, Date.valueOf("2009-01-01"), 4);
//        Property stackedTownHouse2 = new StackedTownHouse(null, "zab" + r.nextInt(1000), 100000, 2, "under", 1, null, 3);
//        propertyService.addNewProperty(stackedTownHouse1);
//        propertyService.addNewProperty(stackedTownHouse2);
//
//        System.out.println("Number of properties: " + propertyService.getAllProperties().size());
//    }
//
//}
