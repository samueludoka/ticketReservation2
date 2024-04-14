package org.smartapplication.services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.smartapplication.dtos.request.*;
import org.smartapplication.dtos.response.*;
import org.smartapplication.exception.InvalidDetailsException;
import org.smartapplication.model.Category;
import org.smartapplication.model.Customer;
import org.smartapplication.model.Ticket;
import org.smartapplication.repository.CustomerRepository;
import org.smartapplication.repository.TicketRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    private final ModelMapper mapper = new ModelMapper();

    private final NotificationService notificationService;

    private final TicketRepository ticketRepository;
    @Override
    public CustomerRegistrationResponse createUserAccount(CreateRegistrationRequest request) {
        Customer customer = new Customer();
        customer.setId(request.getId());
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setPassword(request.getPassword());
        Customer savedCustomer = customerRepository.save(customer);
        CustomerRegistrationResponse response = new CustomerRegistrationResponse();
        response.setId(savedCustomer.getId());
        return response;
    }

    @Override
    public void login(CreateLoginRequest request)  {
        Customer foundCustomer = customerRepository.findByEmail(request.getEmail());
        if(!userExist(request.getEmail())) throw new InvalidDetailsException();
        if(!foundCustomer.getPassword().equals(request.getPassword())) throw new InvalidDetailsException();
        foundCustomer.setLocked(false);
        customerRepository.save(foundCustomer);
    }

    private boolean userExist(String email) {
        Customer foundCustomer = customerRepository.findByEmail(email);
        return foundCustomer != null;
    }

    @Override
    public BookTicketResponse bookTicket(BookTicketRequest bookTicketRequest, AddTicketRequest ticketRequest) throws Exception {
        Category searchTicket = categoryCheck(ticketRequest.getReservationNumber());
        Ticket ticket = mapper.map(bookTicketRequest, Ticket.class);
        Ticket savedTicket = ticketRepository.save(ticket);
        return mapper.map(savedTicket, BookTicketResponse.class);
    }

    private Category categoryCheck(String reservationNumber) throws Exception{
        for(Category cate : Category.values()){
            if(cate.name().equalsIgnoreCase(reservationNumber)){
                return cate;
            }
        }
        throw new Exception("Category not Found");
    }

}
