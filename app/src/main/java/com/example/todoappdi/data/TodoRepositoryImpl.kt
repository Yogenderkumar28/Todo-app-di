package com.example.todoappdi.data

import kotlinx.coroutines.flow.Flow

class TodoRepositoryImpl(
    private val todoDao: TodoDao
): TodoRepository {

    override suspend fun insertTodo(todo: Todo) {
        todoDao.insetTodo(todo)
    }

    override suspend fun deleteTodo(todo: Todo) {
        todoDao.deleteTodo(todo)
    }

    override suspend fun getTodoById(id: Long): Todo? {
        return todoDao.getTodoById(id)
    }

    override fun getTodos(): Flow<List<Todo>> {
        return todoDao.getTodos()
    }

}