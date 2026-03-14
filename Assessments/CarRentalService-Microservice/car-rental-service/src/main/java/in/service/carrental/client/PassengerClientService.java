package in.service.carrental.client;

import in.service.carrental.dto.PassengerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name = "passenger-service")
public interface PassengerClientService {

    @GetMapping("/passengers")
    List<PassengerDto> getAllPassengers();

    @GetMapping("/passengers/{id}")
    PassengerDto getPassengerById(@PathVariable Long id);
}