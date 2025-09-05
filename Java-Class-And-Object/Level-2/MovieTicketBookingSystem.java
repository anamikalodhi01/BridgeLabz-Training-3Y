class MovieTicketBookingSystem {
    String movieName;
    int seatNumber;
    double price;

    MovieTicketBookingSystem(String movieName, int seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    void bookTicket(String movieName, int seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Ticket booked successfully!");
    }

    void displayTicket() {
        System.out.println("Movie: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        MovieTicketBookingSystem ticket = new MovieTicketBookingSystem("", 0, 0);
        ticket.bookTicket("Inception", 12, 250.0);
        ticket.displayTicket();
    }
}
