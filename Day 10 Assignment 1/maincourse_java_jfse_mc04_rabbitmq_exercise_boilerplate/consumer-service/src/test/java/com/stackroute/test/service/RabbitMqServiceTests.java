package com.stackroute.test.service;

import com.stackroute.domain.Employee;
import com.stackroute.service.RabbitMqService;
import com.stackroute.service.TriggerClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RabbitMqServiceTests {

    @Mock
    TriggerClass triggerClass;
    @InjectMocks
    private RabbitMqService rabbitMqService;
    @Mock
    private RabbitTemplate rabbitTemplate;
    @Mock
    private MessageConverter messageConverter;

    private Employee employee;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        employee = new Employee("1", "Test Name");

        // Mock the message
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType("text/plain");
        Message mockMessage = new Message("".getBytes(), messageProperties);

        // Mock the RabbitTemplate behavior
        Mockito.when(messageConverter.fromMessage(mockMessage)).thenReturn(employee);

        // Trigger the message listener
        rabbitMqService.recievedMessage(employee);
    }
    @AfterEach
    public void tearDown() {
        employee = null;
    }

    @Test
    public void testGetIdListener() {
        when(triggerClass.getEmployeeId(employee)).thenReturn(employee.getId());
        verify(triggerClass, times(1)).getEmployeeId(employee);
    }

    @Test
    public void testGetNameListener() {
        when(triggerClass.getEmployeeName(employee)).thenReturn(employee.getName());
        verify(triggerClass, times(1)).getEmployeeName(employee);
    }

    @Test
    public void assertGetIdListener() {
        when(triggerClass.getEmployeeId(employee)).thenReturn(employee.getId());
        assertEquals("Id received from RabbitMQ:1", rabbitMqService.getEmployeeId(employee));
    }
    @Test
    public void assertGetNameListener() {
        when(triggerClass.getEmployeeName(employee)).thenReturn(employee.getName());
        assertEquals("Name received from RabbitMQ:Test Name", rabbitMqService.getEmployeeName(employee));
    }
}
