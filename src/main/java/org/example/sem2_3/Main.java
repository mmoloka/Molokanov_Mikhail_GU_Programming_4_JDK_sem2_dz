package org.example.sem2_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Описать команду разработчиков. В команде разработчиков могут находиться бэкендеры,
которые в состоянии писать серверный код, фронтендеры, которые могут программировать экранные формы,
и фуллстэк разработчики, совмещающие в себе обе компетенции.
Реализовать класс фулстэк разработчика, создать экземпляр и последовательно вызвать все его методы.
Дописать третье задание таким образом, чтобы в идентификатор типа Developer записывался объект Frontender,
 и далее вызывался метод developGUI(), не изменяя существующие интерфейсы, только код основного класса.
 Developer dev = new FrontendDeveloper();
if (dev instanceof Frontender) {
((Frontender) dev).developGUI();
 */
public class Main {
    public static void main(String[] args) {
        FullStack developerFullStack = new DeveloperFullStack();
        BackEnder developerBackEnd = new DeveloperBackEnd();
        List<BackEnder> listDevelopers = Arrays.asList(developerFullStack, developerBackEnd);
        Developer developer = new DeveloperFrontEnd();

        developerFullStack.createServer();
        developerFullStack.createFront();
        developerBackEnd.createServer();

        for (BackEnder dev : listDevelopers) {
            dev.createServer();
        }
        if (developer instanceof FrontEnder) {
            ((FrontEnder) developer).createFront();
        }
    }

    interface BackEnder {
        void createServer();
    }

    interface FrontEnder {
        void createFront();
    }

    interface FullStack extends BackEnder, FrontEnder {
    }

    public static class DeveloperFullStack implements FullStack {

        @Override
        public void createServer() {
            System.out.println("Server is developed");
        }

        @Override
        public void createFront() {
            System.out.println("GUI is developed");
        }
    }

    public static class DeveloperBackEnd implements BackEnder {

        @Override
        public void createServer() {
            System.out.println("Server is dropped");
        }
    }

    interface Developer {
    }

    public static class DeveloperFrontEnd implements FrontEnder, Developer {

        @Override
        public void createFront() {
            System.out.println("GUI is dropped");
        }
    }
}
