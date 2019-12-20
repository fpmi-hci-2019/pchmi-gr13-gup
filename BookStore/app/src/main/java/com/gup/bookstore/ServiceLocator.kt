package com.gup.bookstore

import android.content.Context
import android.content.SharedPreferences
import com.google.firebase.firestore.FirebaseFirestore
import com.gup.bookstore.ui.screens.booklist.BookListViewModel
import com.gup.bookstore.ui.screens.booklist.author.AuthorViewModel
import com.gup.bookstore.ui.screens.booklist.book.BookViewModel
import com.gup.bookstore.ui.screens.login.LoginViewModel
import com.gup.bookstore.ui.screens.main.MainViewModel
import com.gup.bookstore.ui.screens.main.cart.CartViewModel
import com.gup.bookstore.ui.screens.main.catalog.CatalogViewModel
import com.gup.bookstore.ui.screens.main.favorites.FavoritesViewModel
import com.gup.bookstore.ui.screens.main.news.NewsListFragmentViewModel
import com.gup.bookstore.ui.screens.main.profile.ProfileViewModel
import com.gup.bookstore.ui.screens.newslist.NewsListActivityViewModel
import com.gup.bookstore.ui.screens.newslist.news.NewsViewModel
import com.gup.bookstore.ui.screens.publisher.PublisherViewModel
import com.gup.data.repositories.*
import com.gup.data.repositories.LocalFavoritesRepositoryImpl.Companion.PREFS_FAVORITES_NAME
import com.gup.data.repositories.LocalOrderRepositoryImpl.Companion.PREFS_ORDER_NAME
import com.gup.data.repositories.LocalProfileRepository.Companion.PREFS_PROFILE_NAME
import com.gup.data.repositories.LocalSubscriptionsRepositoryImpl.Companion.PREFS_SUBSCRIPTIONS_NAME
import com.gup.domain.repositories.*
import com.gup.domain.usecases.*

class ServiceLocator(app: BookStoreApp) {
    private val appContext = app.applicationContext

    // Repositories

    private val remoteBooksRepository: BooksRepository by lazy {
        RemoteBooksRepositoryImpl(FirebaseFirestore.getInstance())
    }

    private val localFavoritesRepository: FavoritesRepository by lazy {
        val sharedPreferences = newSharedPreferences(PREFS_FAVORITES_NAME)
        LocalFavoritesRepositoryImpl(PreferencesRepositoryImpl(sharedPreferences))
    }

    private val localOrderRepository: OrderRepository by lazy {
        val sharedPreferences = newSharedPreferences(PREFS_ORDER_NAME)
        LocalOrderRepositoryImpl(PreferencesRepositoryImpl(sharedPreferences))
    }

    private val localProfileRepository: ProfileRepository by lazy {
        val sharedPreferences = newSharedPreferences(PREFS_PROFILE_NAME)
        LocalProfileRepository(PreferencesRepositoryImpl(sharedPreferences))
    }

    private val localSubscriptionsRepository: SubscriptionsRepository by lazy {
        val sharedPreferences = newSharedPreferences(PREFS_SUBSCRIPTIONS_NAME)
        LocalSubscriptionsRepositoryImpl(PreferencesRepositoryImpl(sharedPreferences))
    }

    // Common functions

    private fun newSharedPreferences(name: String): SharedPreferences {
        return appContext.getSharedPreferences(
            name,
            Context.MODE_PRIVATE
        )
    }

    // Usecases

    private fun createAddBookToOrderUsecase(): AddBookToOrderUsecase {
        return AddBookToOrderUsecaseImpl(
            localProfileRepository,
            localOrderRepository
        )
    }

    private fun createAddFavoriteUsecase(): AddFavoriteUsecase {
        return AddFavoriteUsecaseImpl(
            localProfileRepository,
            localFavoritesRepository
        )
    }

    private fun createAddSubscriptionUsecase(): AddSubscriptionUsecase {
        return AddSubscriptionUsecaseImpl(
            localProfileRepository,
            localSubscriptionsRepository
        )
    }

    private fun createCheckoutOrderUsecase(): CheckoutOrderUsecase {
        return CheckoutOrderUsecaseImpl(
            localProfileRepository,
            localOrderRepository
        )
    }

    private fun createGetAuthorUsecase(): GetAuthorUsecase {
        return GetAuthorUsecaseImpl(remoteBooksRepository)
    }

    private fun createGetBookPreviewsUsecase(): GetBookPreviewsUsecase {
        return GetBookPreviewsUsecaseImpl(remoteBooksRepository)
    }

    private fun createGetBookUsecase(): GetBookUsecase {
        return GetBookUsecaseImpl(
            localProfileRepository,
            remoteBooksRepository,
            localFavoritesRepository
        )
    }

    private fun createGetFavoriteBookPreviewsUsecase(): GetFavoriteBookPreviewsUsecase {
        return GetFavoriteBookPreviewsUsecaseImpl(
            localProfileRepository,
            remoteBooksRepository,
            localFavoritesRepository
        )
    }

    private fun createGetNewsPreviewsUsecase(): GetNewsPreviewsUsecase {
        return GetNewsPreviewsUsecaseImpl(
            localProfileRepository,
            remoteBooksRepository,
            localSubscriptionsRepository
        )
    }

    private fun createGetNewsUsecase(): GetNewsUsecase {
        return GetNewsUsecaseImpl(remoteBooksRepository)
    }

    private fun createGetPublisherUsecase(): GetPublisherUsecase {
        return GetPublisherUsecaseImpl(
            localProfileRepository,
            remoteBooksRepository,
            localSubscriptionsRepository
        )
    }

    private fun createLoadOrderQuantityUsecase(): LoadOrderQuantityUsecase {
        return LoadOrderQuantityUsecaseImpl(
            localProfileRepository,
            localOrderRepository
        )
    }

    private fun createLoadOrderUsecase(): LoadOrderUsecase {
        return LoadOrderUsecaseImpl(
            localProfileRepository,
            remoteBooksRepository,
            localOrderRepository
        )
    }

    private fun createSaveUserIdUsecase(): SaveUserIdUsecase {
        return SaveUserIdUsecaseImpl(localProfileRepository)
    }

    private fun createLogoutUsecase(): LogoutUsecase {
        return LogoutUsecaseImpl(
            localProfileRepository,
            localFavoritesRepository,
            localOrderRepository,
            localSubscriptionsRepository
        )
    }

    private fun createRemoveBookFromOrderUsecase(): RemoveBookFromOrderUsecase {
        return RemoveBookFromOrderUsecaseImpl(
            localProfileRepository,
            localOrderRepository
        )
    }

    private fun createRemoveFavoriteUsecase(): RemoveFavoriteUsecase {
        return RemoveFavoriteUsecaseImpl(
            localProfileRepository,
            localFavoritesRepository
        )
    }

    private fun createRemoveSubscriptionUsecase(): RemoveSubscriptionUsecase {
        return RemoveSubscriptionUsecaseImpl(
            localProfileRepository,
            localSubscriptionsRepository
        )
    }

    // ViewModels

    fun createAuthorViewModel(id: String): AuthorViewModel {
        return AuthorViewModel(
            id,
            createGetAuthorUsecase()
        )
    }

    fun createBookViewModel(id: String): BookViewModel {
        return BookViewModel(
            id,
            createGetBookUsecase(),
            createAddFavoriteUsecase(),
            createRemoveFavoriteUsecase(),
            createAddBookToOrderUsecase()
        )
    }

    fun createBookListViewModel(): BookListViewModel {
        return BookListViewModel()
    }

    fun createCartViewModel(): CartViewModel {
        return CartViewModel(
            createLoadOrderUsecase(),
            createRemoveBookFromOrderUsecase(),
            createCheckoutOrderUsecase()
        )
    }

    fun createCatalogViewModel(): CatalogViewModel {
        return CatalogViewModel(createGetBookPreviewsUsecase())
    }

    fun createFavoritesViewModel(): FavoritesViewModel {
        return FavoritesViewModel(createGetFavoriteBookPreviewsUsecase())
    }

    fun createLoginViewModel(): LoginViewModel {
        return LoginViewModel(createSaveUserIdUsecase())
    }

    fun createMainViewModel(): MainViewModel {
        return MainViewModel(createLoadOrderQuantityUsecase())
    }

    fun createNewsListActivityViewModel(): NewsListActivityViewModel {
        return NewsListActivityViewModel()
    }

    fun createNewsListFragmentViewModel(): NewsListFragmentViewModel {
        return NewsListFragmentViewModel(createGetNewsPreviewsUsecase())
    }

    fun createNewsViewModel(id: String): NewsViewModel {
        return NewsViewModel(
            id,
            createGetNewsUsecase()
        )
    }

    fun createProfileViewModel(): ProfileViewModel {
        return ProfileViewModel(createLogoutUsecase())
    }

    fun createPublisherViewModel(id: String): PublisherViewModel {
        return PublisherViewModel(
            id,
            createGetPublisherUsecase(),
            createAddSubscriptionUsecase(),
            createRemoveSubscriptionUsecase()
        )
    }
}