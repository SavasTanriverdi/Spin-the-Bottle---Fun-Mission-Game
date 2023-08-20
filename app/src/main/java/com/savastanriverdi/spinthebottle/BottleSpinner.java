package com.savastanriverdi.spinthebottle;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.Random;

public class BottleSpinner {
    private ImageView bottle;
    private Random random = new Random();
    private int lastDir;
    private boolean spinning;

    private String[] tasks = {
            "En komik şaka yap!",
            "En kötü alışkanlığını paylaş.",
            "Bir hayvanın taklidini yap.",
            "Elindeki en tuhaf nesneyi göster.",
            "En sevdiğin film karakterini taklit et.",
            "Yakında yapmak istediğin bir hedefini anlat.",
            "Bir arkadaşına içten bir övgüde bulun.",
            "5 dakika boyunca en sevdiğin şarkıyı söyle!",
            "Hiç gitmek istemediğin bir yer var mı? Neden?",
            "Kendine ait bir dans numarası sergile.",
            "İdeal bir tatil gününü anlat.",
            "En saçma korkun nedir?",
            "Hiç yapılmadık bir spor dalını denemeye ne dersin?",
            "En utanç verici anını paylaş.",
            "Bir arkadaşına hayali bir hediye seç ve neden o hediye olduğunu açıkla.",
            "Eğer bir gün başka birini olabilme şansın olsaydı, kim olurdun ve neden?"
    };


    public BottleSpinner(ImageView bottle) {
        this.bottle = bottle;
    }

    public void spinBottle() {
        if (!spinning) {
            int newDir = random.nextInt(1800);
            float pivotX = bottle.getWidth() / 2;
            float pivotY = bottle.getHeight() / 2;

            Animation rotate = new RotateAnimation(lastDir, newDir, pivotX, pivotY);
            rotate.setDuration(2500);
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;
                    showRandomTask();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            lastDir = newDir;
            bottle.startAnimation(rotate);
        }
    }

    private void showRandomTask() {
        int randomIndex = random.nextInt(tasks.length);
        String selectedTask = tasks[randomIndex];

        // Seçilen görevi veya soruyu oyunculara göstermek için bir pop-up penceresi veya mesaj kullanabilirsiniz.
        // Örneğin, bir AlertDialog kullanarak:
        AlertDialog.Builder builder = new AlertDialog.Builder(bottle.getContext());
        builder.setTitle("Görev");
        builder.setMessage(selectedTask);
        builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Kullanıcı "Tamam" düğmesine tıkladığında yapılması gerekenleri burada gerçekleştirebilirsiniz.
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
