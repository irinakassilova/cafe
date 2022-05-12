package com.example.cafe.service;

import com.example.cafe.model.Basket;
import com.example.cafe.model.Food;
import com.example.cafe.model.User;
import com.example.cafe.repository.BasketRepository;
import com.example.cafe.repository.FoodRepository;
import com.example.cafe.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BasketService {
    private  final BasketRepository basketRepository;
    private final FoodRepository productRepository;
    private final UserRepository userRepository;


    public void createBasket(int count, int id, String email) {
        User user = userRepository.findByEmail(email);
        Food food = productRepository.getById(id);
        Basket basket = new Basket();
        basket.setCount(count);
        basket.setFood(food);
        basket.setUser(user);
        basketRepository.save(basket);
    }
    public List<Basket> getAll() {
        return basketRepository.findAll();
    }

    public  void delete(int id){
        basketRepository.deleteById(id);
    }

    public Optional<Basket> getById(int id) {
        return basketRepository.findById(id);
    }

    public void addProductToSession(HttpSession session, int id) {
        List<Food> products  =new ArrayList<>();
        session.setAttribute("", products);

    }
}

