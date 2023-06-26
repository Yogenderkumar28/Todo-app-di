package com.example.todoappdi.ui.todo_home

import com.example.todoappdi.data.Todo

sealed class TodoListEvent {

    data class OnDeleteTodoClick(val todo:Todo): TodoListEvent()
    data class OnDoneChange(val todo: Todo, val isDone: Boolean): TodoListEvent()
    object OnUndoClick: TodoListEvent()
    data class OnTodoClick(val todo: Todo): TodoListEvent()
    object OnAddTodoClick: TodoListEvent()

}
