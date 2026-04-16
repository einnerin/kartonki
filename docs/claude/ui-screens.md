# Правила: UI-экраны (Compose + Navigation)

## Файлы для чтения перед работой
- `ui/navigation/Route.kt` — все маршруты
- `ui/navigation/AppNavGraph.kt` — регистрация экранов
- Соседний экран-образец (например `ui/screen/study/StudyScreen.kt`)

## Текущие экраны (Route.kt)

| Route | Экран |
|-------|-------|
| Splash | загрузка + seed |
| Home | главное меню |
| Study | список наборов для изучения |
| WordSetDetail | детали набора |
| StudySession | сессия изучения слов |
| ProblemWordsList / ProblemWordsSession | проблемные слова |
| Collection | коллекция карточек |
| MyDecks | мои колоды |
| DeckBuilder | редактор колоды |
| PvpModeSelect | выбор режима PvP |
| PvpDeckSelect | выбор колод |
| PvpGame | локальный PvP |
| OnlineMatchmaking | поиск онлайн-игры |
| OnlinePvpGame | онлайн PvP |
| PackShop | магазин паков |
| PackOpening | открытие пака |
| NewCards | уведомление о новых картах |
| PlayerStats / WordStats | статистика |
| Achievements | достижения |
| Settings | настройки |
| Login | вход через Firebase |

## Чеклист при добавлении нового экрана

1. **Добавь `Route`** в `Route.kt`:
   ```kotlin
   // Без аргументов:
   object MyScreen : Route("my_screen")
   // С аргументами:
   object MyScreen : Route("my_screen/{id}") {
       fun createRoute(id: Long) = "my_screen/$id"
       const val ARG_ID = "id"
   }
   ```

2. **Зарегистрируй в `AppNavGraph.kt`**:
   ```kotlin
   composable(Route.MyScreen.path) {
       MyScreen(onBack = { navController.popBackStack() })
   }
   // С аргументами:
   composable(
       route = Route.MyScreen.path,
       arguments = listOf(navArgument(Route.MyScreen.ARG_ID) { type = NavType.LongType })
   ) { backStackEntry ->
       val id = backStackEntry.arguments?.getLong(Route.MyScreen.ARG_ID) ?: return@composable
       MyScreen(id = id, onBack = { navController.popBackStack() })
   }
   ```

3. **Создай файл** `ui/screen/myscreen/MyScreen.kt` + `MyScreenViewModel.kt`
   - ViewModel: `@HiltViewModel class MyScreenViewModel @Inject constructor(...)`
   - UiState: `data class MyScreenUiState(val isLoading: Boolean = true, ...)`
   - В composable: `val vm: MyScreenViewModel = hiltViewModel()`

4. **Навигация к экрану**:
   ```kotlin
   navController.navigate(Route.MyScreen.path)                    // без аргументов
   navController.navigate(Route.MyScreen.createRoute(someId))     // с аргументами
   ```

## Конвенции

- Один файл = один экран + его локальные composable-компоненты
- Переиспользуемые компоненты → `ui/component/`
- Все строки в `strings.xml`, не хардкодить в Compose
- Side effects через `LaunchedEffect` / `SideEffect`
- Sealed class для UiState если состояний > 2

## Частые ошибки
- Забыл зарегистрировать Route в `AppNavGraph` → навигация к экрану упадёт с `IllegalArgumentException`.
- Передал аргумент типа String без `Uri.encode()` → спецсимволы ломают URL-маршрут (см. PvpGame с именами игроков).
- Не добавил `popUpTo` при навигации назад через Splash/Login → стек копится и кнопка Back ведёт на Splash.
