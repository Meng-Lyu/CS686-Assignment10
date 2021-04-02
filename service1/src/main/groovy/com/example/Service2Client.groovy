package com.example

import com.example.domain.Book
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.CircuitBreaker
import io.micronaut.retry.annotation.Recoverable
import io.reactivex.Flowable

@Client(id = "service2")
@CircuitBreaker(reset = "30s")
@Recoverable(api=Service.class)
interface Service2Client extends Service{

    @Get("/books")
    @Override
    Flowable<ArrayList<Book>> findBooks();
}