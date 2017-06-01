package pl.piotrcz.Ticket.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.piotrcz.Ticket.Models.Ticket;
import pl.piotrcz.Ticket.Models.TicketRepository;

/**
 * Created by Piotr Czubkowski on 2017-06-01.
 */
@Controller
public class MainController {

    @Autowired
    TicketRepository ticketRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String home() {
        Ticket ticket = new Ticket("Jestem wiadomoscia z controllera", "Piotr Czubkowski");
        ticketRepository.save(ticket);
        return "Zapisałem do bazy";
    }
}
