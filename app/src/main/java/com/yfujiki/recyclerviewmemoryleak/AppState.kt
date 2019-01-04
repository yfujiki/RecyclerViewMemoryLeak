package com.yfujiki.recyclerviewmemoryleak

import io.reactivex.subjects.PublishSubject

class AppState {
    companion object {
        val stateSubject: PublishSubject<Boolean> = PublishSubject.create()
    }
}