import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    public void issueLotto() {
        assertThat(new Lotto().getNumbers().size()).isEqualTo(6);
    }

    @Test
    public void issueLottoUseString() {
        assertThat(new Lotto("1,2,3,4,5,6").getNumbers().size()).isEqualTo(6);
    }

    @Test
    public void issueLottoIllegalArgumentException() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void isContainNumberTest() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        lotto.isContainNumber(new LottoNumber(6));
        assertThat(lotto).isEqualTo(new Lotto("1,2,3,4,5,6", 1));
    }
}
