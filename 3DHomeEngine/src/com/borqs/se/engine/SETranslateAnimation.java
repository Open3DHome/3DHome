package com.borqs.se.engine;

import com.borqs.se.engine.SEVector.SEVector3f;

public class SETranslateAnimation extends SEEmptyAnimation {
    private SEObject mObj;
    private SEVector3f mFrom;
    private SEVector3f mTo;
    private boolean mIsLocal;

    public SETranslateAnimation(SEScene scene, SEObject obj, SEVector3f from, SEVector3f to, int times) {
        super(scene, 0, 1, times);
        mObj = obj;
        mFrom = from;
        mTo = to;
        mIsLocal = false;
    }

    public void setIsLocal(boolean isLocal) {
        mIsLocal = isLocal;
    }

    @Override
    public void onAnimationRun(float value) {
        SEVector3f distance = mTo.subtract(mFrom);
        SEVector3f location = mFrom.add(distance.mul(value));
        if (mIsLocal) {
            mObj.setLocalTranslate(location);
        } else {
            mObj.setUserTranslate(location);
        }
    }

}
