package com.scopely.integration.leanplum;

import rx.Observable;
import rx.Subscriber;

public class LeanplumActionResponseErrorTransformOperator implements Observable.Operator<LeanplumActionResponse, LeanplumActionResponse> {
    @Override
    public Subscriber<? super LeanplumActionResponse> call(final Subscriber<? super LeanplumActionResponse> s) {
        return new Subscriber<LeanplumActionResponse>(s) {
            @Override
            public void onCompleted() {
                if (!s.isUnsubscribed()) {
                    s.onCompleted();
                }
            }

            @Override
            public void onError(Throwable t) {
                if (!s.isUnsubscribed()) {
                    s.onError(t);
                }
            }

            @Override
            public void onNext(LeanplumActionResponse item) {
                if (!s.isUnsubscribed()) {
                    if (item.success) {
                        s.onNext(item);
                    } else {
                        s.onError(new LeanplumException(item));
                    }
                }
            }
        };
    }
}
