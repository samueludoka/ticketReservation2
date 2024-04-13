package org.smartapplication.services;

import com.github.fge.jsonpatch.JsonPatchOperation;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.smartapplication.dtos.request.CreateLoginRequest;
import org.smartapplication.dtos.request.CreateRegistrationRequest;
import org.smartapplication.dtos.request.UpdateCustomerRequest;
import org.smartapplication.dtos.response.ApiResponse;
import org.smartapplication.dtos.response.CustomerRegistrationResponse;
import org.smartapplication.dtos.response.CustomerResponse;
import org.smartapplication.dtos.response.UpdateCustomerResponse;
import org.smartapplication.exception.CustomerNotFoundException;
import org.smartapplication.exception.InvalidDetailsException;
import org.smartapplication.model.Customer;
import org.smartapplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    private final ModelMapper mapper = new ModelMapper();

    private final NotificationService notificationService;
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

    @Override
    public CustomerResponse getCustomerBy(Long id) throws CustomerNotFoundException {
        return mapper.map(findCustomerBy(id), CustomerResponse.class);
    }

    @Override
    public ApiResponse<UpdateCustomerResponse> updateCustomer(Long l, UpdateCustomerRequest updateCustomerRequest) {

//        Customer customer = findCustomerBy(id);
//
//        List<JsonPatchOperation> jsonPatchOperations = new ArrayList<>();
//        buildPatchOperation(updateCustomerRequest, jsonPatchOperations);
//        customer = applyPatch(jsonPatchOperations, customer);
//        customerRepository.save(customer);
//        notify(id, notificationService.createNotification(new sendNotificationRequest(id, "account updated successfully")));

        return null;
    }

    private Customer findCustomerBy(Long id) throws CustomerNotFoundException{
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("Customer with id %d not found", id)));
    }

    private boolean userExist(String email) {
        Customer foundCustomer = customerRepository.findByEmail(email);
        return foundCustomer != null;
    }


}
