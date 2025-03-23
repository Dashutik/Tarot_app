package com.example.tarot_beta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {
    private TextView textQuestion;
    private RadioGroup radioGroup;
    private RadioButton[] radioButtons;
    private Button submitButton;
    private int currentQuestion = 0;
    private int correctAnswersCount = 0;

    // Массив вопросов
    private final Victorina[] questions = {
            new Victorina("Какое основное значение имеет карта Маг?", new String[]{"Начало нового пути", "Сила творчества", "Внутренняя трансформация", "Физическая сила"}, 0),
            new Victorina("Какая карта считается картой духовного просвещения?", new String[]{"Императрица", "Верховная Жрица", "Отшельник", "Колесо Судьбы"}, 1),
            new Victorina("Что означает появление Смерти в раскладе?", new String[]{"Физическая смерть", "Конец отношений", "Превращение и трансформация", "Болезнь"}, 2),
            new Victorina("Какой элемент ассоциируется с Жрецом?", new String[]{"Огонь", "Земля", "Воздух", "Вода"}, 2),
            new Victorina("Какое значение имеет Восьмёрка Чаш в классическом толковании?", new String[]{"Новая любовь", "Уход от прошлого", "Материальное богатство", "Духовный рост"}, 1)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quize_activity);

        textQuestion = findViewById(R.id.cardTitleTextView);
        radioGroup = findViewById(R.id.вариантыГруппа);
        submitButton = findViewById(R.id.submitButton);

        radioButtons = new RadioButton[]{
                findViewById(R.id.ответ1),
                findViewById(R.id.ответ2),
                findViewById(R.id.ответ3),
                findViewById(R.id.ответ4)
        };

        updateQuestion();

        submitButton.setOnClickListener(v -> checkQuestion());
    }

    private void updateQuestion() {
        if (currentQuestion < questions.length) {
            Victorina currentVictorina = questions[currentQuestion];
            textQuestion.setText(currentVictorina.getQuestion());

            String[] answerOptions = currentVictorina.getAnswerOptions();
            for (int i = 0; i < radioButtons.length; i++) {
                radioButtons[i].setText(answerOptions[i]);
            }

            radioGroup.clearCheck();
        }
    }

    private void checkQuestion() {
        int selectedAnswerId = radioGroup.getCheckedRadioButtonId();
        int selectedAnswerIndex = -1;

        for (int i = 0; i < radioButtons.length; i++) {
            if (radioButtons[i].getId() == selectedAnswerId) {
                selectedAnswerIndex = i;
                break;
            }
        }

        if (selectedAnswerIndex == -1) {
            Toast.makeText(this, "Пожалуйста, выберите ответ!", Toast.LENGTH_SHORT).show();
            return;
        }

        Victorina currentVictorina = questions[currentQuestion];
        if (selectedAnswerIndex == currentVictorina.getCorrectAnswer()) {
            correctAnswersCount++;
            Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Неправильно!", Toast.LENGTH_SHORT).show();
        }

        currentQuestion++;
        if (currentQuestion < questions.length) {
            updateQuestion();
        } else {
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("correctAnswersCount", correctAnswersCount);
            startActivity(intent);
            finish();
        }
    }
}