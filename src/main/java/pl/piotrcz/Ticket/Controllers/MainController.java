package pl.piotrcz.Ticket.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.piotrcz.Ticket.Models.Ticket;
import pl.piotrcz.Ticket.Models.TicketRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Piotr Czubkowski on 2017-06-01.
 */
@Controller
public class MainController {

    @Autowired
    TicketRepository ticketRepository;

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


    @RequestMapping(value = "/{ticketId}", method = RequestMethod.GET)
    @ResponseBody
    public String home(@PathVariable("ticketId") int id) {
        List<Ticket> tickets = ticketRepository.findByMessage("Wiadomość%");

        String messages = "Tickety rozpoczynające się od 'wiaodmość:'";
        for (Ticket ticket : tickets) {
            messages += ticket.getMessage() + " , ";
        }
        return messages;

    }
}
