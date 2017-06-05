package pl.piotrcz.Ticket.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import pl.piotrcz.Ticket.MailService;
import pl.piotrcz.Ticket.Models.TicketRepository;
import pl.piotrcz.Ticket.Models.User;
import pl.piotrcz.Ticket.Models.UserRepository;

/**
 * Created by Piotr Czubkowski on 2017-06-01.
 */
@Controller
public class MainController {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    MailService mailService;

    @Autowired
    TemplateEngine templateEngine;

//    @Autowired
//    User2Repository user2Repository;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    @ResponseBody
//    public String home() {
////        Zapisywanie ticket do bazy
////        Ticket ticket = new Ticket("Jestem wiadomoscia z controllera", "Piotr Czubkowski");
////        ticketRepository.save(ticket);
////        return "Zapisałem do bazy";
//
////        odczyt z bazy konretnego tekstu z konkretnego Id
//        Ticket ticket = ticketRepository.findOne(2);
//        return "Odczytałen z bazy wiadomość: " + ticket.getMessage();
//    }

//    @RequestMapping(value = "/{ticketId}", method = RequestMethod.GET)
//    @ResponseBody
//    public String home(@PathVariable("ticketId") int id) {
//        Ticket ticket = ticketRepository.findOne(id);
//        return "Odczytałen z bazy wiadomość: " + ticket.getMessage();
//    }

//    @RequestMapping(value = "/{ticketId}",method = RequestMethod.GET)
//    @ResponseBody
//    public String home(@PathVariable("ticketId")int id){
//        Optional<Ticket>ticket = ticketRepository.findOne(id);
//
//        if(ticket.isPresent()){
//            return "odczytałem z bazy:" + ticket.get().getMessage();
//        }
//        return "Brak wyników o takim id w bazie";
////        return ticket.map(s-> "Dana z bazy " + s.getMessage()).orElse("Brak danych");
//    }

//    @RequestMapping(value = "/{ticketId}", method = RequestMethod.GET)
//    @ResponseBody
//    public String home(@PathVariable("ticketId") int id) {
//        List<Ticket> tickets = ticketRepository.findByAuthor("Piotr Czubkowski");
//
//        String messages = "Tickety Piotra Czubkowskiego";
//        for (Ticket ticket : tickets) {
//            messages += ticket.getMessage() + " , ";
//        }
//        return messages;
////        return tickets
////                .stream()
////                .map(s->s.getMessage())
////                .collect(Collectors.joining(" , ", " Tickety: ", " , "));
//    }


//    @RequestMapping(value = "/{ticketId}", method = RequestMethod.GET)
//    @ResponseBody
//    public String home(@PathVariable("ticketId") int id) {
//        List<Ticket> tickets = ticketRepository.findByMessage("Wiadomość%");
//
//        String messages = "Tickety rozpoczynające się od 'wiaodmość:'";
//        for (Ticket ticket : tickets) {
//            messages += ticket.getMessage() + " , ";
//        }
//        return messages;
//
//    }

//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    @ResponseBody
//    public String user(){
//        User2 user = userRepository.findOne( 180);
//        return "Czas: " + user.getDatetime().toString();
//    }

//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    @ResponseBody
//    public String user2() {

//        List<User2> user2s = user2Repository.findByRole("Adnim");
//        return user2s.stream().map(s -> s.getUsername()).collect(Collectors.joining(" , ", "", ""));

//
//        DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date1 = null;
//        Date date2 = null;
//
//        try {
//            date1 =  formater.parse("2017-04-12 16:32:06");
//            date2 = formater.parse("2017-06-13 00:00:00");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        List<User2> user2s = user2Repository.findByDatetimeBetween(date1, date2);
//        return user2s.stream().map(s -> s.getUsername()).collect(
//                Collectors.joining(" , ", "Role: ", ""));


//        List<User2> users = user2Repository.findByUsernameContainingAndIdGreaterThan("os", 3);
//        return users.stream().map(s->s.getUsername()).collect(Collectors.joining(" , ", "Role:", ""));

//        Page<User2> currentPage = user2Repository.findAll(new PageRequest(0,4));
//        StringBuilder builder = new StringBuilder();
//
//        for (User2 user2 : currentPage.getContent()){
//            builder.append("Username: " + user2.getUsername() + "<br>");
//        }
//
//        builder.append("<br> Ilość stron: " + currentPage.getTotalPages());
//        builder.append("<br> Czy zawiera następna stronę? " + currentPage.hasNext());
//        builder.append("<br> Czy zawiera poprzednią stronę?" + currentPage.hasPrevious());
//
//        currentPage.nextPageable();
//
//        builder.append("<br><br><br>");
//
//        for (User2 user2 : currentPage.nextPageable().){
//            builder.append("Username: " + user2.getUsername() + "<br>");
//        }
//
//        return builder.toString();

//    }

//    -------------------------------------------------------------------------------


    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public String user() {


        Page<User> currentPage = userRepository.findAll(new PageRequest(0, 4));
        StringBuilder builder = new StringBuilder();

        for (User user : currentPage.getContent()) {
            builder.append("Username: " + user.getUsername() + "<br>");
        }

        builder.append("<br><br><br><br>");

        builder.append("<br> Ilość stron: " + currentPage.getTotalPages());
        builder.append("<br> Czy zawiera następną stronę?: " + currentPage.hasNext());
        builder.append("<br> Czy zawiera poprzednią stronę?: " + currentPage.hasPrevious());

        currentPage.nextPageable();

        builder.append("<br><br><br><br>");

        for (User user : currentPage.getContent()) {
            builder.append("Username: " + user.getUsername() + "<br>");
        }

//        currentPage.map();

        return builder.toString();
    }
//        Mail

//    @RequestMapping (value = "/mail", method = RequestMethod.GET)
//    @ResponseBody
//    public String email(){
//        mailService.sendEmail("piotrcz@o2.pl", "<b><h1> Jakas wiadomosc</h1></b>", "Wyslane z Javy");
//        return "Wyslano maila";
//    }


    @RequestMapping(value = "/mail/{cash}", method = RequestMethod.GET)
    @ResponseBody
    public String email(@PathVariable("cash") int cash) {
        Context context = new Context();
        context.setVariable("welcome", "Witaj Piotrze");
        context.setVariable("message", "Wiszisz mi pieniądze" + cash + " zl");

        String bodyHtml = templateEngine.process("emailone", context);
        mailService.sendEmail("piotrcz@o2.pl", bodyHtml, "Wyslane z Javy");
        return "Wyslano maila";
    }
}





