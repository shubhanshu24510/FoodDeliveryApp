package food.data

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import food.domain.ChipSelectorState
import food.domain.SelectionMode

class ChipSelectorStateImpl(
    // 1
    override val chips: List<String>,
    // 2
    selectedChips: List<String> = emptyList(),
    // 3
    val mode: SelectionMode = SelectionMode.Single,
) : ChipSelectorState {
    // 4
    override var selectedChips by mutableStateOf(selectedChips)

    // 5
    override fun onChipClick(chip: String) {
        if (mode == SelectionMode.Single) {
            if (!selectedChips.contains(chip)) {
                selectedChips = listOf(chip)
            }
        } else {
            selectedChips = if (selectedChips.contains(chip)) {
                selectedChips - chip
            } else {
                selectedChips + chip
            }
        }
    }

    // 6
    override fun isSelected(chip: String): Boolean = selectedChips.contains(chip)

    companion object {
        // 7
        val saver = Saver<ChipSelectorStateImpl, List<*>>(
            save = { state ->
                buildList {
                    add(state.chips.size)
                    addAll(state.chips)
                    add(state.selectedChips.size)
                    addAll(state.selectedChips)
//                    add(state.mode.index)
                }
            },
            restore = { items ->
                var index = 0
                val chipsSize = items[index++] as Int
                val chips = List(chipsSize) {
                    items[index++] as String
                }
                val selectedSize = items[index++] as Int
                val selectedChips = List(selectedSize) {
                    items[index++] as String
                }
//                val mode = SelectionMode.fromIndex(items[index] as Int)
                ChipSelectorStateImpl(
                    chips = chips,
                    selectedChips = selectedChips,
//                    mode = mode,
                )
            }
        )
    }
}
@Composable
fun rememberChipSelectorState(
    chips: List<String>,
    selectedChips: List<String> = emptyList(),
    mode: SelectionMode = SelectionMode.Single,
): ChipSelectorState {
    if (chips.isEmpty()) error("No chips provided")
    if (mode == SelectionMode.Single && selectedChips.size > 1) {
        error("Single choice can only have 1 pre-selected chip")
    }

    return rememberSaveable(
        saver = ChipSelectorStateImpl.saver
    ) {
        ChipSelectorStateImpl(
            chips,
            selectedChips,
            mode,
        )
    }
}