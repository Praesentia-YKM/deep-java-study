/**
 * 아래 코드에서 count 변수는 외부에서 접근할 수 없고, 오직 내부 함수(increment, decrement 등)를 통해서만 접근할 수 있습니다.
 * 이것이 클로저를 사용한 데이터 은닉의
 *
 * 자바스크립트에서 클로저를 사용하여 변수를 private하게 만들 수 있습니다.
 * 클로저는 외부에서 직접 접근할 수 없는 변수를 내부 함수에서 참조하고 조작할 수 있도록 하기 때문에,
 * 데이터를 보호할 수 있습니다.
 *
 */
//클로저를 통한 count
function createAdvancedCounter(initialValue) {
    let count = initialValue || 0;  // 초기값 설정, 없으면 0으로 초기화

    return {
        // 카운트를 증가시키는 함수
        increment: function(step = 1) {
            count += step;
            console.log(`Counter incremented by ${step}: ${count}`);
            return count;
        },
        // 카운트를 감소시키는 함수
        decrement: function(step = 1) {
            count -= step;
            console.log(`Counter decremented by ${step}: ${count}`);
            return count;
        },
        // 카운트를 현재 값으로 출력하는 함수
        getValue: function() {
            console.log(`Current counter value: ${count}`);
            return count;
        },
        // 카운트를 초기값으로 리셋하는 함수
        reset: function(newInitialValue) {
            count = newInitialValue || 0;
            console.log(`Counter reset to ${count}`);
            return count;
        }
    };
}

// 카운터 생성
const counter1 = createAdvancedCounter(10);  // 초기값 10으로 설정

// 카운터 기능 테스트
counter1.increment();        // 1씩 증가
counter1.increment(5);       // 5씩 증가
counter1.decrement(3);       // 3씩 감소
counter1.getValue();         // 현재 카운트 값 확인
counter1.reset();            // 카운터 리셋


console.log("-----");

const counter2 = createAdvancedCounter(50);  // 두 번째 카운터, 초기값 50
counter2.increment(10);      // 10씩 증가
counter2.decrement(20);      // 20씩 감소
counter2.getValue();         // 현재 카운트 값 확인
counter2.reset(100);         // 새로운 값으로 리셋
counter2.getValue();         // 현재 카운트 값 확인
