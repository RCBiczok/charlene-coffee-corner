package coffee.charlene.ch;

import java.util.List;

public interface Customizable {

    List<? extends Addable> getExtras();
}
