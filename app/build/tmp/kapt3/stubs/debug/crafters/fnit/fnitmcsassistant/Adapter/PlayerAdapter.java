package crafters.fnit.fnitmcsassistant.Adapter;

@kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcrafters/fnit/fnitmcsassistant/Adapter/PlayerAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcrafters/fnit/fnitmcsassistant/Adapter/PlayerAdapter$ViewHolder;", "playerSet", "", "Lcrafters/fnit/fnitmcsassistant/Adapter/DataClass/Player;", "([Lcrafters/fnit/fnitmcsassistant/Adapter/DataClass/Player;)V", "getPlayerSet", "()[Lcrafters/fnit/fnitmcsassistant/Adapter/DataClass/Player;", "[Lcrafters/fnit/fnitmcsassistant/Adapter/DataClass/Player;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class PlayerAdapter extends android.support.v7.widget.RecyclerView.Adapter<crafters.fnit.fnitmcsassistant.Adapter.PlayerAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final crafters.fnit.fnitmcsassistant.Adapter.DataClass.Player[] playerSet = null;
    
    @org.jetbrains.annotations.NotNull()
    public final crafters.fnit.fnitmcsassistant.Adapter.DataClass.Player[] getPlayerSet() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public crafters.fnit.fnitmcsassistant.Adapter.PlayerAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.Nullable()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.Nullable()
    crafters.fnit.fnitmcsassistant.Adapter.PlayerAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public PlayerAdapter(@org.jetbrains.annotations.NotNull()
    crafters.fnit.fnitmcsassistant.Adapter.DataClass.Player[] playerSet) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcrafters/fnit/fnitmcsassistant/Adapter/PlayerAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "playerIcon", "Landroid/widget/ImageView;", "getPlayerIcon", "()Landroid/widget/ImageView;", "setPlayerIcon", "(Landroid/widget/ImageView;)V", "playerName", "Landroid/widget/TextView;", "getPlayerName", "()Landroid/widget/TextView;", "setPlayerName", "(Landroid/widget/TextView;)V", "status", "getStatus", "setStatus", "app_debug"})
    public static final class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView playerName;
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView playerIcon;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView status;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getPlayerName() {
            return null;
        }
        
        public final void setPlayerName(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getPlayerIcon() {
            return null;
        }
        
        public final void setPlayerIcon(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getStatus() {
            return null;
        }
        
        public final void setStatus(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}