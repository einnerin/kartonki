# Правила: UI-экраны (Compose + Navigation)

## Файлы для чтения перед работой
- `ui/navigation/Route.kt` — все маршруты
- `ui/navigation/AppNavGraph.kt` — регистрация экранов
- Соседний экран-образец (например `ui/screen/study/StudyScreen.kt`)

## Текущие маршруты (Route.kt)

Splash · Home · Study · WordSetDetail · StudySession · ProblemWordsList · ProblemWordsSession · Collection · MyDecks · DeckBuilder · PvpModeSelect · PvpDeckSelect · PvpGame · OnlineMatchmaking · OnlinePvpGame · PackShop · PackOpening · NewCards · PlayerStats · WordStats · Achievements · Settings · Login

## Чеклист при добавлении экрана

1. **`Route.kt`** — добавь объект маршрута:
   ```kotlin
   object MyScreen : Route("my_screen")                              // без аргументов
   object MyScreen : Route("my_screen/{id}") {                      // с аргументом
       fun createRoute(id: Long) = "my_screen/$id"
       const val ARG_ID = "id"
   }
   ```

2. **`AppNavGraph.kt`** — зарегистрируй composable с аргументами если нужны

3. **Файл экрана** `ui/screen/myscreen/MyScreen.kt` + `MyScreenViewModel.kt`:
   - `@HiltViewModel class MyScreenViewModel @Inject constructor(...)`
   - `data class MyScreenUiState(val isLoading: Boolean = true, ...)`
   - В composable: `val vm: MyScreenViewModel = hiltViewModel()`

4. **Навигация:** `navController.navigate(Route.MyScreen.path)`

## Конвенции
- Один файл = один экран + его локальные composable-компоненты
- Переиспользуемые компоненты → `ui/component/`
- Все строки в `strings.xml`, не хардкодить в Compose
- Side effects через `LaunchedEffect` / `SideEffect`

## Частые ошибки
- Не зарегистрировал Route в `AppNavGraph` → `IllegalArgumentException` при навигации
- String-аргумент без `Uri.encode()` → спецсимволы ломают маршрут
- Нет `popUpTo` при выходе из Splash/Login → Back ведёт обратно на Splash
