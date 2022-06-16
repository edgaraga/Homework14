import java.util.Arrays;

public class TicketManager {

private TicketRepository repository;
public TicketManager(TicketRepository repository){this.repository = repository;}

    public void add(Ticket ticket) {repository.save(ticket);}
    public Ticket[] findAll(String from, String to) {
        Ticket[] tickets = repository.findTicked();
        Ticket[] ans = new Ticket[0];
        for ( Ticket ticket :  tickets) {
            if (ticket.getDepartureAirport() == from && ticket.getArrivalAirport() == to) {
                Ticket[] tmp = new Ticket[ans.length + 1];
                for (int i = 0; i < ans.length; i++) {
                    tmp[i] = ans[i];

                }
                tmp[tmp.length -1] = ticket;
                ans = tmp;
            }
        }
        Arrays.sort(ans);
        return ans;
    }
}
