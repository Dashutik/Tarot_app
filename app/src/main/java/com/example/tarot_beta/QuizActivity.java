package com.example.tarot_beta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    // UI элементы
    private TextView tvQuestion;
    private RadioGroup rgAnswers;
    private RadioButton rbAnswer1, rbAnswer2, rbAnswer3, rbAnswer4;
    private Button btnSubmit;

    // Данные викторины
    private final List<QuizQuestion> questions = new ArrayList<>();

    public List<QuizQuestion> getQuestions() {
        return questions;
    }
    private int currentQuestionIndex = 0;
    private int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Инициализация UI
        initViews();

        // Загрузка вопросов
        loadQuestions();

        // Показать первый вопрос
        showQuestion();

        // Обработчик кнопки
        btnSubmit.setOnClickListener(v -> checkAnswer());
    }

    private void initViews() {
        tvQuestion = findViewById(R.id.tv_question);
        rgAnswers = findViewById(R.id.rg_answers);
        rbAnswer1 = findViewById(R.id.rb_answer1);
        rbAnswer2 = findViewById(R.id.rb_answer2);
        rbAnswer3 = findViewById(R.id.rb_answer3);
        rbAnswer4 = findViewById(R.id.rb_answer4);
        btnSubmit = findViewById(R.id.btn_submit);
    }

    private void loadQuestions() {
        try {
            InputStream is = getResources().openRawResource(R.raw.questions);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder jsonString = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }

            JSONArray jsonArray = new JSONArray(jsonString.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject q = jsonArray.getJSONObject(i);
                String question = q.getString("question");
                JSONArray answers = q.getJSONArray("answers");
                int correct = q.getInt("correctAnswer");

                questions.add(new QuizQuestion(
                        question,
                        new String[]{
                                answers.getString(0),
                                answers.getString(1),
                                answers.getString(2),
                                answers.getString(3)
                        },
                        correct
                ));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Ошибка загрузки вопросов", Toast.LENGTH_SHORT).show();
        }
        Collections.shuffle(questions);
    }

    private void showQuestion() {
        if (currentQuestionIndex < 6) {
            QuizQuestion current = questions.get(currentQuestionIndex);
            tvQuestion.setText(current.getQuestion());
            rbAnswer1.setText(current.getAnswers()[0]);
            rbAnswer2.setText(current.getAnswers()[1]);
            rbAnswer3.setText(current.getAnswers()[2]);
            rbAnswer4.setText(current.getAnswers()[3]);
            rgAnswers.clearCheck();
        } else {
            showResults();
        }
    }

    private void checkAnswer() {
        int selectedId = rgAnswers.getCheckedRadioButtonId();

        if (selectedId == -1) {
            Toast.makeText(this, "Выберите ответ!", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton selected = findViewById(selectedId);
        int answerIndex = rgAnswers.indexOfChild(selected);

        if (answerIndex == questions.get(currentQuestionIndex).getCorrectAnswer()) {
            correctAnswers++;
            Toast.makeText(this, "Верно!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Неверно!", Toast.LENGTH_SHORT).show();
        }

        currentQuestionIndex++;
        showQuestion();
    }

    private void showResults() {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("SCORE", correctAnswers);
        intent.putExtra("TOTAL", 6);
        startActivity(intent);
        finish();
    }

    // Класс для хранения вопроса
    private static class QuizQuestion {
        private final String question;
        private final String[] answers;
        private final int correctAnswer;

        public QuizQuestion(String question, String[] answers, int correctAnswer) {
            this.question = question;
            this.answers = answers;
            this.correctAnswer = correctAnswer;
        }

        public String getQuestion() {
            return question;
        }

        public String[] getAnswers() {
            return answers;
        }

        public int getCorrectAnswer() {
            return correctAnswer;
        }
    }
}