package armenta.jose.thecheezery

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val buttonColdDrinks = findViewById<Button>(R.id.button_cold_drinks)
        buttonColdDrinks.setOnClickListener {
            val intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("CATEGORY", "cold_drinks")
            startActivity(intent)
        }

        val buttonHotDrinks = findViewById<Button>(R.id.button_hot_drinks)
        buttonHotDrinks.setOnClickListener {
            val intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("CATEGORY", "hot_drinks")
            startActivity(intent)
        }

        val buttonSweets = findViewById<Button>(R.id.button_sweets)
        buttonSweets.setOnClickListener {
            val intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("CATEGORY", "sweets")
            startActivity(intent)
        }

        val buttonSalties = findViewById<Button>(R.id.button_salties)
        buttonSalties.setOnClickListener {
            val intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("CATEGORY", "salties")
            startActivity(intent)
        }
    }
}