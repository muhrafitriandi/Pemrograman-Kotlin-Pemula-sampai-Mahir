package coroutine.kotlin.cancellable_flow.case1

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import org.junit.jupiter.api.Test

class Case1Test {
    fun dataFromDatabase(): List<String> {
        return listOf(
            "Apple",
            "Banana",
            "Mango",
            "Orange",
            "Avocado"
        )
    }

    fun searchOnServer(query: String): Flow<List<String>> = flow {
        val results = mutableListOf<String>()

        dataFromDatabase().forEach { data ->
            if (data.startsWith(query)) results.add(data)
        }
        emit(results)
    }

    @Test
    fun testSearchData() {
        val scope = CoroutineScope(Dispatchers.IO)
        val job = scope.launch {
            searchOnServer("X")
                .onEach {
                    if (it.isNotEmpty()) println("Found: $it")
                    else {
                        println("Not found")
                        cancel()
                    }
                }
                .collect()
        }

        runBlocking {
            job.join()
        }
    }
}