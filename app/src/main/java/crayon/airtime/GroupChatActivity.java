package crayon.airtime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import co.intentservice.chatui.ChatView;
import co.intentservice.chatui.models.ChatMessage;

/**
 * Created by yash on 8/10/17.
 */

public class GroupChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent intent = this.getIntent();
        String title = "Movies";
        if(intent.hasExtra("GROUP_NAME"))
            title = intent.getStringExtra("GROUP_NAME");

        getSupportActionBar().setTitle(title);

        ChatView chatView = (ChatView) findViewById(R.id.chat_view);

        chatView.addMessage(new ChatMessage("Vagisha:\nHey! I am a big fan of bollywood movies.",
                System.currentTimeMillis(), ChatMessage.Type.RECEIVED));
        chatView.addMessage(new ChatMessage("Yash:\nHey Guys!!", System.currentTimeMillis(),
                ChatMessage.Type.RECEIVED));
        chatView.addMessage(new ChatMessage("Heyy!", System.currentTimeMillis(), ChatMessage.Type
                .SENT));

        chatView.addMessage(new ChatMessage("Vagisha: \nHave you guys wateched Dangal?", System
                .currentTimeMillis(), ChatMessage.Type.RECEIVED));
        chatView.addMessage(new ChatMessage("Simran: \nOne with Salman Khan. Right?", System
                .currentTimeMillis(), ChatMessage.Type.RECEIVED));

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
