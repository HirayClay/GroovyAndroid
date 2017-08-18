package groovy.trial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle
import groovy.transform.CompileStatic;
@CompileStatic
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
