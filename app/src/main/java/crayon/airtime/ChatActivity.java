package crayon.airtime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.intentservice.chatui.ChatView;
import co.intentservice.chatui.models.ChatMessage;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        Intent intent = this.getIntent();
        String title = "Rahul Arora";
        if (intent.hasExtra("PERSON_NAME"))
            title = intent.getStringExtra("PERSON_NAME");
        getSupportActionBar().setTitle(title);

        ChatView chatView = (ChatView) findViewById(R.id.chat_view);

        chatView.addMessage(new ChatMessage("Hey!",
                System.currentTimeMillis(), ChatMessage.Type.RECEIVED));
        chatView.addMessage(new ChatMessage("Hi!", System.currentTimeMillis(), ChatMessage.Type
                .SENT));

        chatView.setOnSentMessageListener(new ChatView.OnSentMessageListener() {
            @Override
            public boolean sendMessage(ChatMessage chatMessage) {
                return true;
            }
        });


        chatView.setTypingListener(new ChatView.TypingListener() {
            @Override
            public void userStartedTyping() {

            }

            @Override
            public void userStoppedTyping() {

            }
        });
    }
}
