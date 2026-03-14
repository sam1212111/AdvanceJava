package com.pament.gateaway;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class OrderItemTest {
	@Mock
	PamentGateaway pg;
	
	@InjectMocks
	OrderItem oi;
	
	
	@Test
	void testInvalidAge() {
		assertThrows(IllegalArgumentException.class,()->oi.placeOrderItem(0));
	}
	

}
