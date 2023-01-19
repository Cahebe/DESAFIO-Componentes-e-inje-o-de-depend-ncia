package com.devsuperior.desafio.application;

import com.devsuperior.desafio.entities.Order;
import com.devsuperior.desafio.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;


@SpringBootApplication
@ComponentScan({"com.devsuperior.desafio."})
public class DesafioApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(DesafioApplication.class, args);
    }

    Scanner sc = new Scanner(System.in);
    @Autowired
    private OrderService orderService;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Dados do pedido:");
        System.out.print("Código: ");
        int code = sc.nextInt();
        System.out.print("Valor básico: ");
        double basic = sc.nextDouble();
        System.out.print("Porcentagem de desconto: ");
        double discount = sc.nextDouble();
        Order order = new Order(code, basic, discount);

        System.out.println("Pedido código " + order.getCode());
        System.out.print("Valor total: " + orderService.total(order));
    }
}
