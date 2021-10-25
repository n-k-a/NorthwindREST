package org.sparta.northwindrest.services;

import org.sparta.northwindrest.dto.EmployeeDTO;
import org.sparta.northwindrest.dto.OrderDTO;
import org.sparta.northwindrest.dto.ProductNamesDTO;
import org.sparta.northwindrest.entities.EmployeeEntity;
import org.sparta.northwindrest.entities.OrderEntity;
import org.sparta.northwindrest.repositories.EmployeeRepository;
import org.sparta.northwindrest.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDTO> getAllEmployees() {
        return ((List<EmployeeEntity>) employeeRepository
                .findAll())
                .stream()
                .map(this::convertToEmployeeDTO)
                .collect(Collectors.toList());
    }
    public Optional<EmployeeDTO> getById(Integer id) {
        return
                Optional.ofNullable(employeeRepository.findAll().stream().map(this::convertToEmployeeDTO)
                        .filter(o -> id.equals(o.getId()))
                        .findAny()
                        .orElse(null));
    }

    private EmployeeDTO convertToEmployeeDTO(EmployeeEntity employeeEntity) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employeeEntity.getId()) ;
                employeeDTO.setFirstName(employeeEntity.getFirstName());
                employeeDTO.setLastName(employeeEntity.getLastName());
                employeeDTO.setTitle(employeeEntity.getTitle());
                employeeDTO.setTitleOfCourtesy(employeeEntity.getTitleOfCourtesy());
               employeeDTO.setAddress( employeeEntity.getAddress());
                employeeDTO.setRegion(employeeEntity.getRegion());
                employeeDTO.setPostalCode(employeeEntity.getPostalCode());
                employeeDTO.setCountry(employeeEntity.getCountry());
                employeeDTO.setPostalCode(employeeEntity.getPostalCode());
                employeeDTO.setHomePhone(employeeEntity.getHomePhone());
                employeeDTO.setExtension(employeeEntity.getExtension());
          //      employeeDTO.setReportsTo(employeeEntity.getReportsTo().getFirstName() + " " + employeeEntity.getReportsTo().getLastName());


        return employeeDTO;
    }
}
