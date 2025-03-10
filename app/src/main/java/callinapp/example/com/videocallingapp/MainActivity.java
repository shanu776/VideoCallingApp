package callinapp.example.com.videocallingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.vidyo.VidyoClient.Connector.Connector;
import com.vidyo.VidyoClient.Connector.ConnectorPkg;

public class MainActivity extends AppCompatActivity implements Connector.IConnect {

    private Connector vc;
    private FrameLayout videoFeame;
    private Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button) findViewById(R.id.start);
        ConnectorPkg.setApplicationUIContext(this);
        ConnectorPkg.initialize();

        videoFeame = (FrameLayout) findViewById(R.id.video_frame);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vc = new Connector(videoFeame, Connector.ConnectorViewStyle.VIDYO_CONNECTORVIEWSTYLE_Default,16,"","",0);
                vc.showViewAt(videoFeame, 0, 0, videoFeame.getWidth(), videoFeame.getHeight());
            }
        });

    }

    public void start(View v){


    }
    public void connect(View v){
        String token = "";
        vc.connect("prod.vidyo.io",token,"User", "DemoRoom", this);
    }
    public void disconnect(View v){
        vc.disconnect();
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFailure(Connector.ConnectorFailReason connectorFailReason) {

    }

    @Override
    public void onDisconnected(Connector.ConnectorDisconnectReason connectorDisconnectReason) {

    }
}
