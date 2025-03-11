package eazySchool.eazySchool.controller;

import eazySchool.eazySchool.Service.ContactService;
import eazySchool.eazySchool.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {
    private static final Logger logloger = LoggerFactory.getLogger(ContactController.class);
    ContactService contactService;
    @Autowired
    public ContactController(ContactService contactService) {
     this.contactService = contactService;
    }
    @RequestMapping("/contact")
   public String displayContactPage(){
        return "contact.html";
    }
//    @RequestMapping("/saveMsg")
//    public ModelAndView saveMsg(@RequestParam String name,@RequestParam String mobileNum,
//                                @RequestParam String email,@RequestParam String subject,
//                                @RequestParam String message){
////        logloger.info("Name: "+name);
////        logloger.info("Mobile Number: "+mobileNum);
////        logloger.info("Email: "+email);
////        logloger.info("Subject: "+subject);
////        logloger.info("Message: "+message);
//
//        return new ModelAndView("redirect:/contact");
//
//    }

    @RequestMapping("/saveMsg")
    public ModelAndView saveMsg(Contact contact){
//        logloger.info("Name: "+name);
//        logloger.info("Mobile Number: "+mobileNum);
//        logloger.info("Email: "+email);
//        logloger.info("Subject: "+subject);
//        logloger.info("Message: "+message);
        contactService.saveMessageDetails(contact);
        return new ModelAndView("redirect:/contact");

    }

}
