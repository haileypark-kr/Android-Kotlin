import kotlin.contracts.contract

/*
미니프로젝트 (2)
- 문제 1번과 2번 사이에 1번 문제의 답을 적어주세요.
- 오답일 경우에도 부분 점수가 있기 때문에 모르시는 부분이 있더라도 최대한 작성 해주세요
*/

/*
1번 (Part-클래스)
다음 조건을 만족하는 클래스를 작성해주세요.
아래 조건에 언급되어 있는 않은 부분은 자유롭게 작성해주세요
- 1> 클래스 이름은 Duck 입니다.
- 2> 주생성자는 정수형 age를 받습니다 (val/var 자유)
- 3> 부생성자는 정수형 age와 문자열 color를 받습니다 (val/var 자유)
- 4> Duck 클래스는 walk라는 기능이 있고, 이 기능을 실행하면 "뒤뚱뒤뚱 걷는다" 라를 출력합니다. (반환값 없음)
- 5> Duck 클래스는 quack라는 기능이 있고, 이 기능은 정수형 number를 인자로 받고, number의 수 만큼 "꽥"을 출력합니다. (반환값 없음)
     ex) number가 3인 경우, "꽥"을 3번 출력합니다.
 */

/*
2번 (Part-상속)
다음을 보고 알맞게 작성해주세요
아래 조건에 언급되어 있는 않은 부분은 자유롭게 작성해주세요
- 아래 Cat클래스를 상속받는 Tiger 클래스를 작성해주세요.
- Tiger 클래스는 Cat 인터페이스에 있는 jump를 구현 해야 합니다
    - Tiger 클래스의 jump는 number 를 받고 다음 문자열을 반환 합니다 "number 미터를 점프 하였습니다" (number는 인자로 들어온 정수)
    - ex) "3 미터를 점프 하였습니다" 를 반환
 */
class Cat constructor(age: Int) {
    val age: Int

    fun jump(number: Int): String
}

/*
3번 (Part-인터페이스)
다음 조건을 만족하는 인터페이스를 작성해주세요.
아래 조건에 언급되어 있는 않은 부분은 자유롭게 작성해주세요
- 1> 인터페이스 이름은 Worker 입니다.(반환값 없음)
- 2> Worker는 work 기능이 있습니다.(반환값 없음)
- 3> Worker는 promotion 기능이 있습니다.
 */

/*
4번 (Part-안드로이드 UI)
다음 조건을 만족하는 View component를 아래 있는 답 작성란에 순서대로 작성해주세요.
- 1> 가로, 세로 크기가 100dp이고 orientation이 vertical인 LinerLayoutCompat을 만들어 주세요.
- 2> 가로 크기는 match_parent, 세로 크기는 50dp이고, layout_marginLeft이 10dp이고 orientation이 horizontal인 LinerLayoutCompat를 만들어주세요.
- 3> 가로, 세로 크기가 30dp이고 gravity가 center이고 text는 "안녕하세요" TextView를 만들어주세요.
문제 풀이는 XML 파일에서 진행을 해주시고, 답안은 코틀린 파일(.kt/.kts)에 복붙해서 제출 부탁드립니다 (복붙시 에러가 발생하여도 무방합니다)
아래 조건에 언급되어 있는 않은 부분은 자유롭게 작성해주세요
 */
<?xml version ="1.0" encoding ="utf-8"?>
<androidx.appcompat.widget.LinearLayoutCompat xmlns : android ="http://schemas.android.com/apk/res/android"
android:layout_width = "match_parent"
android:layout_height = "match_parent"
android:orientation = "vertical" >

/*
답 작성란
 */

</androidx.appcompat.widget.LinearLayoutCompat >

/*
5번 (Part-클래스,인터페이스)
아래 조건을 만족하는 코드를 작성해주세요.
아래 조건에 언급되어 있는 않은 부분은 자유롭게 작성해주세요
Step 1
- 두 수의 곱하기, 나누기(몫), 더하기, 빼기 기능이 있는 인터페이스 Calculator를 자유롭게 선언하세요 (함수명, 변수명 등등 자유입니다)
Step 2
- Calculator 인터페이스를 구현하는 RealCalculator 클래스를 만들어주세요. (Calculator 인터페이스의 기능(함수)를 모두 구현해야 합니다)
 */

/*
6번 (Part-안드로이드 UI)
- 자유롭게 화면을 바둑판식으로 균등하게 9등분(3x3) 하여 텍스트 뷰 9개를 배치해 주세요. (텍스트 뷰 9개를 합한 면적이 한 화면을 꽉 채워야 합니다)
    - 바둑판식으로 균등하게 등분을 할 때 직접적으로 width나 height를 dp로 설정 하시면 안됩니다 (한 화면의 크기가 변경되면 균등해지지 않기때문)
- 텍스트 뷰 속성은 자유롭게 설정하여도 무방하지만 9개가 구분이 되도록 색을 지정해 주세요.
- LinearLayout, RelativeLayout 등등 자유롭게 사용해 주세요.
문제 풀이는 XML 파일에서 진행을 해주시고, 답안은 코틀린 파일(.kt/.kts)에 복붙해서 제출 부탁드립니다 (복붙시 에러가 발생하여도 무방합니다)
 */