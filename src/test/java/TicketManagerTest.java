import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TicketManagerTest {

    Ticket ticket1 = new Ticket(1, 3500, "SVO", "SVP", 620);
    Ticket ticket2 = new Ticket(2, 2800, "SVO", "SVS", 450);
    Ticket ticket3 = new Ticket(3, 1370, "SVO", "SVP", 850);
    Ticket ticket4 = new Ticket(4, 2900, "SVO", "SVP", 230);
    Ticket ticket5 = new Ticket(5, 3100, "SVB", "SVP", 480);
    Ticket ticket6 = new Ticket(6, 1370, "SVO", "SVP", 470);


    @Test
    public void shouldFindAndSortTicket() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.findAll("SVO", "SVP");
        Ticket[] expected = {ticket3, ticket4, ticket1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAndSortTicketNoMatch() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.findAll("SVO", "NVP");
        Ticket[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAndPriceMatch() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);


        Ticket[] actual = manager.findAll("SVO", "SVP");
        Ticket[] expected = {ticket3, ticket6, ticket4, ticket1};

        assertArrayEquals(expected, actual);
    }
}
