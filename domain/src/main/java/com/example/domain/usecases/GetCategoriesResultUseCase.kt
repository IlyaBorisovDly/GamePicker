package com.example.domain.usecases

import com.example.domain.entities.enums.Category
import com.example.domain.entities.states.Status
import com.example.domain.entities.items.ItemResult
import com.example.domain.mappers.toResultItemListStatus
import com.example.domain.repositories.*

class GetCategoriesResultUseCase(
    private val creatorRepository: CreatorRepository,
    private val publisherRepository: PublisherRepository,
    private val genreRepository: GenreRepository,
    private val developerRepository: DeveloperRepository,
    private val platformRepository: PlatformRepository
) {

    suspend operator fun invoke(category: Category): Status<List<ItemResult>> {
        return when(category) {
            Category.Creators -> creatorRepository.getCreators().toResultItemListStatus()
            Category.Publishers -> publisherRepository.getPublishers().toResultItemListStatus()
            Category.Genres -> genreRepository.getGenres().toResultItemListStatus()
            Category.Developers -> developerRepository.getDevelopers().toResultItemListStatus()
            Category.Platforms ->  platformRepository.getPlatforms().toResultItemListStatus()
        }
    }
}