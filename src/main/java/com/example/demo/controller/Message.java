package com.example.demo.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                   // создаёт геттеры, сеттеры, toString, equals и hashCode
@AllArgsConstructor     // создаёт конструктор с аргументами для всех полей
@NoArgsConstructor      // создаёт конструктор без аргументов (обязателен для @RequestBody)
public class Message {
    private String text;
}