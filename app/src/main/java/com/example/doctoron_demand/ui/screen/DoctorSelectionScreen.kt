import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.doctoron_demand.R
import com.example.doctoron_demand.data.models.Doctor
import com.example.doctoron_demand.data.models.Symptom
import com.example.doctoron_demand.data.repository.MockDoctorsRepository
import com.example.doctoron_demand.ui.component.DoctorSelection
import com.example.doctoron_demand.ui.theme.LightBlue

@Composable
fun DoctorSelectionScreen(
    navController: NavController,
    selectedSymptoms: List<String>,
    selectedDuration: String
) {
    val (selectedDoctorId, setSelectedDoctorId) = remember { mutableStateOf("") }

    Image(
        painter = painterResource(id = R.drawable.disclaimer_bg),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.width(640.dp).height(1000.dp).fillMaxWidth().fillMaxHeight()
    )

    Box(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(700.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "Selected Symptoms",
                    fontSize = 20.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(5.dp))

                val rowSymptoms = selectedSymptoms.chunked(3)

                rowSymptoms.forEach { rowItems ->
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        rowItems.forEach { item ->
                            Text(
                                text = item,
                                color = Color.White,
                                modifier = Modifier
                                    .background(LightBlue)
                                    .padding(6.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Duration of Symptoms",
                    fontSize = 20.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "2 weeks",
                    color = Color.White,
                    modifier = Modifier
                        .background(LightBlue)
                        .padding(6.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Available Doctors",
                    fontSize = 20.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(20.dp))


                // Split doctors data in chunks of 2 items to show them 2 in each row
                val doctors = getFilteredDoctors(selectedSymptoms)

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    DoctorSelection(doctors, selectedDoctorId, setSelectedDoctorId)
                }
                
                Button(
                    enabled = selectedDoctorId.isNotEmpty(),
                    onClick = {
                        navController.navigate(
                            "appointment/{doctorId}"
                                .replace(
                                    oldValue = "{doctorId}",
                                    newValue = selectedDoctorId
                                )
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text(text = "Book Appointment")

                }
            }
        }
    }
}

fun getFilteredDoctors(symptoms: List<String>): MutableList<Doctor> {
    val doctorRepository = MockDoctorsRepository()
    val availableDoctors = doctorRepository.getDoctors()

    val filteredDoctors = mutableListOf<Doctor>()

    availableDoctors.forEach { doctor ->
        val doctorSymptoms = doctor.symptoms.map { s -> s.name }

        if(doctorSymptoms.containsAll(symptoms)) {
            filteredDoctors.add(doctor)
        }
    }

    return filteredDoctors

}