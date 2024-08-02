package foods.domain

import androidx.compose.runtime.Stable

enum class SelectionMode {
    Single,
    Multiple,
}


@Stable
interface ChipSelectorState {
    val chips: List<String>
    val selectedChips: List<String>
    fun onChipClick(chip: String)
    fun isSelected(chip: String): Boolean
}