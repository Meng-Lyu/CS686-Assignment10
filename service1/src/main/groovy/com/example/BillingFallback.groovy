package com.example.controller

import com.example.Service
import com.example.domain.Book
import io.micronaut.retry.annotation.Fallback
import io.micronaut.retry.annotation.Recoverable
import io.reactivex.Flowable

@Fallback
@Recoverable
public class BillingFallback implements Service {

    @Override
    public Flowable<ArrayList<Book>> findBooks() {
        Book book = new Book(title: "No response from service2.", author: "Service2 is down.", isbn: "This is by fallback.")

        return Flowable.just([book])
    }
}
