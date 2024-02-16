package coroutine.kotlin.state_flow.case1

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.junit.jupiter.api.Test

data class Todo(val id: Int, val task: String, val completed: Boolean)

class TodoManager {
    private val _todoList = MutableStateFlow(emptyList<Todo>().toMutableList())
    val todoList = _todoList.asStateFlow()

    fun addTodo(todo: Todo) {
        _todoList.value.add(todo)
    }

    fun toggleTodoCompletion(todoId: Int) {
        _todoList.value = _todoList.value.map {
            if (it.id == todoId) it.copy(completed = !it.completed)
            else it
        }.toMutableList()
    }

    fun deleteTodo(todoId: Int) {
        _todoList.value.removeIf { it.id == todoId }
    }
}

class Case1Test {
    @Test
    fun testTodo() {
        val scope = CoroutineScope(Dispatchers.IO)
        val todoManager = TodoManager()

        scope.launch {
            todoManager.todoList.collect { todoList ->
                println("Daftar Tugas Terbaru:")
                todoList.forEach { todo ->
                    println("${todo.id}. ${if (todo.completed) "[x]" else "[ ]"} ${todo.task}")
                }
            }
        }

        todoManager.addTodo(Todo(1, "Belajar Kotlin Coroutine", completed = false))
        todoManager.addTodo(Todo(2, "Membangun aplikasi Android", completed = false))
        todoManager.addTodo(Todo(3, "Mengikuti webinar", completed = false))

        todoManager.toggleTodoCompletion(1)
        todoManager.deleteTodo(3)

        runBlocking {
            delay(2000)
            scope.cancel()
        }
    }
}