package com.example.todoappdi.data

import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    suspend fun insertTodo(todo: Todo)

    suspend fun deleteTodo(todo: Todo)

    suspend fun getTodoById(id: Long): Todo?

    fun getTodos(): Flow<List<Todo>>
}