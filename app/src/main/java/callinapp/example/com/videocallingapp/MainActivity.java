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
        String token = "cHJvdmlzaW9uAGJoYW51QDM5OTRkOS52aWR5by5pbwA2MzcxMTQ5OTU0OAAAODE4ZTEwOWU0YWIxYTk0ZWJhMmU3ZGI2YTRlMTM3NmEwY2EwYTg3NjA1YzdhNWFlMWVmNDg2ZmY5NjA2Y2M4YWRhNmU5NDg0MTQ0MGRkMWIyMTc5YjY1ZDI1YTlhNzEy";
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
