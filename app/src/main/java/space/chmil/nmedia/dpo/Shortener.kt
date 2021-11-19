package space.chmil.nmedia.dpo
import android.util.Log

object Shortener {

    fun shortenTheNumber(likes: Int): String {
        val length = likes.toString().length

        val nomer : String = likes.toString()

        val digits = nomer.map(Character::getNumericValue).toIntArray()



        var total = when(length){
            in 0..3 -> "$likes"

            in 4..4 -> {
                "${digits[0]}${if(digits[1] == 0){""}else ".${digits[1]}"}K"
            }
            in 5..5 -> {
                "${digits[0]}${digits[1]}K"

            }
            in 6..6 -> {
                "${digits[0]}${digits[1]}${digits[2]}K"
            }
            in 7..7 -> {
                "${digits[0]}${if(digits[1] == 0){""}else ".${digits[1]}"}M"
            }
            in 8..8 -> {
                "${digits[0]}${digits[1]}.${digits[2]}M"

            }
            in 9..9 -> {
                "${digits[0]}${digits[1]}${digits[2]}.${digits[3]}M"
            }


            else -> " "
        }



        return total
    }

}