package com.example.domain.usecase

import com.example.domain.Category
import com.example.domain.Status
import com.example.domain.entity.item.ResultItem
import com.example.domain.mapper.toResultItemListStatus
import com.example.domain.repository.*

class GetCategoriesResultUseCase(
    private val creatorRepository: CreatorRepository,
    private val publisherRepository: PublisherRepository,
    private val genreRepository: GenreRepository,
    private val developerRepository: DeveloperRepository,
    private val platformRepository: PlatformRepository
) {

    suspend operator fun invoke(category: Category): Status<List<ResultItem>> {
        return when(category) {
            Category.Creators -> creatorRepository.getCreators().toResultItemListStatus()
            Category.Publishers -> publisherRepository.getPublishers().toResultItemListStatus()
            Category.Genres -> genreRepository.getGenres().toResultItemListStatus()
            Category.Developers -> developerRepository.getDevelopers().toResultItemListStatus()
            Category.Platforms ->  platformRepository.getPlatforms().toResultItemListStatus()
        }
    }
}