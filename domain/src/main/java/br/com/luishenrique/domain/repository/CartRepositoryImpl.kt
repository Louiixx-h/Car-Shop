package br.com.luishenrique.domain.repository

import br.com.luishenrique.domain.entity.CarDTO
import br.com.luishenrique.domain.service.ApiCartService
import br.com.luishenrique.domain.service.Result

class CartRepositoryImpl(private val apiService: ApiCartService): CartRepository {

    override suspend fun getAllCart(page: Int): Result<List<CarDTO>?> {
        return try {
            val response = apiService.getAllCarts(page)
            if (response.isSuccessful) {
                if (response.body() == null) {
                    Result.Error(exception = Exception("Lista de carros vazia!"))
                } else {
                    if (response.body()!!.isEmpty()) {
                        Result.EmptyList(exception = Exception("Lista de carros vazia!"))
                    } else {
                        Result.Success(data = response.body())
                    }
                }
            }
            else Result.Error(exception = Exception("Erro ao buscar na api!"))
        } catch (e: Exception) {
            Result.Error(exception = Exception("Erro ao buscar na api!"))
        }
    }
}