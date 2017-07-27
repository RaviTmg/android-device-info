package com.aduech.www.deviceinfo;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.File;

public class Memory extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        getSupportActionBar().setTitle("Memory Info");  // provide compatibility to all the versions
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //RAM information
        ActivityManager actManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
        actManager.getMemoryInfo(memInfo);
        long RAMtotalMemory = memInfo.totalMem / 1048576L;



        //memory
        File pathOS = Environment.getRootDirectory();//Os Storage
        StatFs statOS = new StatFs(pathOS.getPath());

        File pathInternal = Environment.getDataDirectory();// Internal Storage
        StatFs statInternal = new StatFs(pathInternal.getPath());

        File pathSdcard = Environment.getExternalStorageDirectory();//External(SD CARD) Storage
        StatFs statSdcard = new StatFs(pathSdcard.getPath());

        long TotalOsMemory,FreeOsMemory,UsedOsMemory,TotalInternalMemory,FreeInternalMemory,U‌​sedInternalMemory,To‌​talSdcardMemory,Free‌​SdcardMemory,UsedSdc‌​ardMemory;
        if((android.os.Build.VERSION.SDK_INT < 18)) {
            // Get Android OS (system partition) free space API 18 & Below
            int totalBlocksOS = statOS.getBlockCount();
            int blockSizeOS = statOS.getBlockSize();
            int availBlocksOS = statOS.getAvailableBlocks();
            long total_OS_memory = (long) totalBlocksOS * (long) blockSizeOS;
            long free_OS_memory = (long) availBlocksOS * (long) blockSizeOS;
            long Used_OS_memory = total_OS_memory - free_OS_memory;
            TotalOsMemory       =   total_OS_memory / 1048576L;
            FreeOsMemory        =   free_OS_memory / 1048576L;
            UsedOsMemory        =   Used_OS_memory / 1048576L;

            // Get internal (data partition) free space API 18 & Below
            int totalBlocksInternal = statInternal.getBlockCount();
            int blockSizeInternal = statOS.getBlockSize();
            int availBlocksInternal = statInternal.getAvailableBlocks();
            long total_Internal_memory = (long) totalBlocksInternal * (long) blockSizeInternal;
            long free_Internal_memory = (long) availBlocksInternal * (long) blockSizeInternal;
            long Used_Intenal_memory = total_Internal_memory - free_Internal_memory;
            TotalInternalMemory =   total_Internal_memory / 1048576L;
            FreeInternalMemory  =   free_Internal_memory / 1048576L;
            U‌​sedInternalMemory  =   Used_Intenal_memory / 1048576L;

            // Get external (SDCARD) free space for API 18 & Below
            int totalBlocksSdcard = statSdcard.getBlockCount();
            int blockSizeSdcard = statOS.getBlockSize();
            int availBlocksSdcard = statSdcard.getAvailableBlocks();
            long total_Sdcard_memory = (long) totalBlocksSdcard * (long) blockSizeSdcard;
            long free_Sdcard_memory = (long) availBlocksSdcard * (long) blockSizeSdcard;
            long Used_Sdcard_memory = total_Sdcard_memory - free_Sdcard_memory;
            To‌​talSdcardMemory   =   total_Sdcard_memory / 1048576L;
            Free‌​SdcardMemory    =   free_Sdcard_memory / 1048576L;
            UsedSdc‌​ardMemory    =   Used_Sdcard_memory / 1048576L;
        }
        else {
            // Get Android OS (system partition) free space for API 18 & Above
            long   total_OS_memory          = (statOS.       getBlockCountLong()      * statOS.getBlockSizeLong());
            long   free_OS_memory           = (statOS.       getAvailableBlocksLong() * statOS.getBlockSizeLong());
            long Used_OS_memory = total_OS_memory - free_OS_memory;
            TotalOsMemory       =   total_OS_memory / 1048576L;
            FreeOsMemory        =   free_OS_memory / 1048576L;
            UsedOsMemory        =   Used_OS_memory / 1048576L;

            // Get internal (data partition) free space for API 18 & Above
            long   total_Internal_memory    = (statInternal. getBlockCountLong()      * statInternal.getBlockSizeLong());
            long   free_Internal_memory     = (statInternal. getAvailableBlocksLong() * statInternal.getBlockSizeLong());
            long Used_Internal_memory = total_Internal_memory - free_Internal_memory;
            TotalInternalMemory =   total_Internal_memory / 1048576L;
            FreeInternalMemory  =   free_Internal_memory / 1048576L;
            U‌​sedInternalMemory  =   Used_Internal_memory / 1048576L;

            // Get external (SDCARD) free space for API 18 & Above
            long   total_Sdcard_memory      = (statSdcard.   getBlockCountLong()      * statSdcard.getBlockSizeLong());
            long   free_Sdcard_memory       = (statSdcard.   getAvailableBlocksLong() * statSdcard.getBlockSizeLong());
            long Used_Sdcard_memory = total_Sdcard_memory - free_Sdcard_memory;
            To‌​talSdcardMemory   =   total_Sdcard_memory / 1048576L;
            Free‌​SdcardMemory    =   free_Sdcard_memory / 1048576L;
            UsedSdc‌​ardMemory    =   Used_Sdcard_memory / 1048576L;
        }


        String memory =  "\n"+ TotalOsMemory+"\n"+FreeOsMemory+"\n"+UsedOsMemory+"\n"+TotalInternalMemory +"\n"+ FreeInternalMemory +"\n"+ U‌​sedInternalMemory+"\n"+To‌​talSdcardMemory+"\n"+Free‌​SdcardMemory+"\n"+UsedSdc‌​ardMemory;


        String [] key =  {"Total RAM :","Total Os Memory :", "Free Os Memory :", "Used Os Memory :", "Total Internal Memory :", "FreeInternalMemory :", "U‌​sed Internal Memory :", "To‌​tal Sdcard Memory :", "Free‌ ​Sdcard Memory :", "Used Sdc‌​ard Memory :"};
        String [] value =  {String.valueOf(RAMtotalMemory),String.valueOf(TotalOsMemory), String.valueOf(FreeOsMemory), String.valueOf(UsedOsMemory), String.valueOf(TotalInternalMemory), String.valueOf(FreeInternalMemory), String.valueOf(U‌​sedInternalMemory), String.valueOf(To‌​talSdcardMemory), String.valueOf(Free‌​SdcardMemory), String.valueOf(UsedSdc‌​ardMemory)};

        Litem[] items = new Litem[value.length];


        int count = key.length;
        for(int i = 0; i < count; i++) {
            items[i] = new Litem();
            items[i].setKey(key[i]);
            items[i].setValue(value[i]);
        }

        ListAdapter la = new CustomAdapter(this, items);
        ListView lv = (ListView) findViewById(R.id.listview);
        lv.setAdapter(la);

    }
}
